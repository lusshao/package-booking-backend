package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ParcalControllerTest {

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Autowired
    private ParcelRepository parcelRepository;

    @BeforeEach
    void setup(){ mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build(); }

    @Test
    public void should_return_all_message_when_invoke_showAll_parcel() throws Exception {

        Parcel parcel = new Parcel("123456","liam","13873332016",1,new Timestamp(new Date().getTime()));
        parcelRepository.save(parcel);

        ResultActions result = mockMvc.perform(get("/parcel"));

        result.andExpect(status().isOk()).andExpect(jsonPath("$[0].parcelNumber",is("123456")));
        parcelRepository.deleteAll();

    }

    @Test
    public void should_return_parcel_message_when_invoke_parcel_repository_get_all_by_status_given_parcelStatus(){
        Parcel parcel1 = new Parcel("123876","liam","13873332016",1,new Timestamp(new Date().getTime()));
        Parcel parcel2 = new Parcel("123789","liam","13873332016",2,new Timestamp(new Date().getTime()));
        Parcel parcel3 = new Parcel("123987","liam","13873332016",3,new Timestamp(new Date().getTime()));
        parcelRepository.save(parcel1);
        parcelRepository.save(parcel2);
        parcelRepository.save(parcel3);

        List<Parcel> parcelList = parcelRepository.findAllByParcelStatus(2);

        assertThat(parcelList.get(0).getParcelNumber()).isEqualTo("123789");
    }
    @Test
    public void should_return_parcel_message_when_get_to_parcel_gievn_parcelStatus() throws Exception {
        Parcel parcel1 = new Parcel("123876","liam","13873332016",1,new Timestamp(new Date().getTime()));
        Parcel parcel2 = new Parcel("123789","liam","13873332016",2,new Timestamp(new Date().getTime()));
        Parcel parcel3 = new Parcel("123987","liam","13873332016",3,new Timestamp(new Date().getTime()));

        parcelRepository.save(parcel1);
        parcelRepository.save(parcel2);
        parcelRepository.save(parcel3);

        ResultActions result = mockMvc.perform(get("/parcel?status={status}",2));

        result.andExpect(status().isOk()).andExpect(jsonPath("$[0].parcelNumber",is("123789")));
    }
}
