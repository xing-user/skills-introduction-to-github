package com.ri.demoheadline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ri.demoheadline.pojo.NewsUser;
import com.ri.demoheadline.service.NewsUserService;
import com.ri.demoheadline.mapper.NewsUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 章康宁
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2025-05-13 17:06:37
*/
@Service
public class NewsUserServiceImpl extends ServiceImpl<NewsUserMapper, NewsUser>
    implements NewsUserService{

}




