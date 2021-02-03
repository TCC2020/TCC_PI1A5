package br.edu.ifsp.spo.bulls.feed.api.service;

import br.edu.ifsp.spo.bulls.common.api.dto.FriendshipStatusTO;
import br.edu.ifsp.spo.bulls.common.api.dto.GetFriendStatusTO;
import br.edu.ifsp.spo.bulls.common.api.dto.ProfileTO;
import br.edu.ifsp.spo.bulls.common.api.feign.UserCommonFeign;
import br.edu.ifsp.spo.bulls.feed.api.bean.PostBeanUtil;
import br.edu.ifsp.spo.bulls.feed.api.dto.PostTO;
import br.edu.ifsp.spo.bulls.feed.api.enums.TypePost;
import br.edu.ifsp.spo.bulls.feed.api.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FeedServiceTest {

    @MockBean
    private PostRepository mockPostRepository;

    @MockBean
    private UserCommonFeign feign;

    @Autowired
    private FeedService service;

    @Autowired
    private PostBeanUtil postBeanUtil;

    private ProfileTO profileTO = new ProfileTO();
    private FriendshipStatusTO statusTO = new FriendshipStatusTO();
    private GetFriendStatusTO getStatus = new GetFriendStatusTO();

    @BeforeEach
    public void setup() {
        profileTO.setId(1);

        statusTO = new FriendshipStatusTO();
        getStatus = new GetFriendStatusTO();
    }


    @Test
    public void getFeed() {
        Page<PostTO> postPage = null;
        Pageable pageRequest = PageRequest.of(
                0,
                1,
                Sort.Direction.ASC,
                "id");
        Mockito.when(mockPostRepository.findFeedByRequesterId(profileTO.getId(), pageRequest)).thenReturn(postPage);
        Mockito.when(feign.getProfileByToken("token")).thenReturn(profileTO);

        Page<PostTO> result = service.getFeed("token" , 0, 1);
        assertEquals(postPage, result);
    }

    @Test
    public void getProfileFeed() {
        Page<PostTO> postPage = null;
        statusTO.setStatus("added");
        getStatus.setProfileId(1);
        getStatus.setProfileFriendId(2);
        Pageable pageRequest = PageRequest.of(
                0,
                1,
                Sort.Direction.ASC,
                "id");
        Mockito.when(mockPostRepository.findFeedByRequesterId(profileTO.getId(), pageRequest)).thenReturn(postPage);
        Mockito.when(feign.getProfileByToken("token")).thenReturn(profileTO);
        Mockito.when(feign.getFriendshipStatusTO(getStatus)).thenReturn(statusTO);


        Page<PostTO> result = service.getProfileFeed("token" , 2, 0, 1);
        assertEquals(postPage, result);
    }
}
