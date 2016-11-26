package com.fase.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.IBlock;
import com.fase.mapper.BlockingMapper;
import com.fase.mapper.SettimeMapper;
import com.fase.po.Blocking;
import com.fase.po.Settime;
@Service
@Transactional
public class FblockingService implements IBlock {
   @Resource
   private BlockingMapper bdao;
   @Resource
   private SettimeMapper sdao;
	@Override
	public void updateBlock(Blocking b) {
		// TODO 自动生成的方法存根
         bdao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int insertBlock(Blocking b) {
		// TODO 自动生成的方法存根
		
		return bdao.insertSelective(b);
	}

	@Override
	public int deleteBlock(Map<String,Object>param) {
		// TODO 自动生成的方法存根
      return  bdao.deletebyfb(param);
	}

	@Override
	public List<Blocking> selectall(String fuid) {
		// TODO 自动生成的方法存根
		return bdao.selectallbyfuid(fuid);
	}

	@Override
	public void updatesetting(Settime s) {
		// TODO 自动生成的方法存根
		sdao.updateByPrimaryKeySelective(s);
	}

	@Override
	public Settime selectsetting(String fuid) {
		// TODO 自动生成的方法存根
		return sdao.selectByPrimaryKey(fuid);
	}



}
