package com.qgzx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qgzx.entity.Notice;
import com.qgzx.mapper.NoticeMapper;
import com.qgzx.service.NoticeService;
import org.springframework.stereotype.Service;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/7/11 2:15
 * @modified By:
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>  implements NoticeService {
}
