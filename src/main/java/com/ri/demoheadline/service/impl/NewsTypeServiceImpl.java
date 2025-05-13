package com.ri.demoheadline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ri.demoheadline.pojo.NewsType;
import com.ri.demoheadline.service.NewsTypeService;
import com.ri.demoheadline.mapper.NewsTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author 章康宁
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2025-05-13 17:06:37
*/
@Service
public class NewsTypeServiceImpl extends ServiceImpl<NewsTypeMapper, NewsType>
    implements NewsTypeService{

}




