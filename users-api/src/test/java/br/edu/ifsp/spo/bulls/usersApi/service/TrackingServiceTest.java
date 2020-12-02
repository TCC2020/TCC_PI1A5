package br.edu.ifsp.spo.bulls.usersApi.service;

import br.edu.ifsp.spo.bulls.usersApi.bean.TrackingBeanUtil;
import br.edu.ifsp.spo.bulls.usersApi.bean.UserBooksBeanUtil;
import br.edu.ifsp.spo.bulls.usersApi.repository.TrackingRepository;
import br.edu.ifsp.spo.bulls.usersApi.repository.UserBooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TrackingServiceTest {

    @MockBean
    UserBooksRepository mockUserBooksRepository;

    @MockBean
    UserBooksService mockUserBooksService;

    @MockBean
    TrackingRepository mockTrackingRepository;

    @MockBean
    ReadingTrackingService mockBeadingTrackingService;

    @Autowired
    TrackingBeanUtil beanUtil;

    @Autowired
    TrackingService trackingService;

    @Autowired
    UserBooksBeanUtil userBooksBeanUtil;

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_get_all_trackings_by_userbook() {
    }

    @Test
    void shouldnt_get_all_trackings_by_userbook_when_userbooks_not_found() {
    }

    @Test
    void should_get_one_tracking_by_id() {
    }

    @Test
    void shouldnt_get_one_tracking_by_id_when_tracking_not_found() {
    }

    @Test
    void should_save_tracking() {
    }

    @Test
    void shouldnt_save_tracking_when_other_is_open() {
    }

    @Test
    void should_delete_tracking() {
    }

    @Test
    void shouldnt_delete_tracking_when_tracking_not_found() {
    }

    @Test
    void should_update_tracking() {
    }

    @Test
    void shouldnt_update_tracking_when_tracking_not_found() {
    }
}