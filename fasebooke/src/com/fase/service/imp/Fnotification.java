package com.fase.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Inotification;
import com.fase.mapper.NotificationMapper;
import com.fase.po.Notification;
@Service
@Transactional
public class Fnotification implements Inotification {
   @Resource
   private NotificationMapper nodao;
	@Override
	public List<Notification> selectbyfuid(String fuid) {
		// TODO 自动生成的方法存根
		return nodao.selectByfuid(fuid);
	}

	@Override
	public void updatenotice(Notification uid) {
		// TODO 自动生成的方法存根
         nodao.updateByPrimaryKeySelective(uid);
	}

}
