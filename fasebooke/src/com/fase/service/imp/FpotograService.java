package com.fase.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fase.iservice.Iphotogra;
import com.fase.mapper.PhotogalleryMapper;
import com.fase.mapper.PictureMapper;
import com.fase.po.Photogallery;
import com.fase.po.Picture;
@Service
@Transactional
public class FpotograService implements Iphotogra {
    @Resource
    private PhotogalleryMapper pdao;
    @Resource
    private PictureMapper picturedao;
	@Override
	public Integer insertito(Map<String, Object> params) {
		// TODO 自动生成的方法存根
		pdao.insertP(params);
		return (Integer) params.get("result");
	}

	@Override
	public List<Photogallery> selectall(String fuid) {
		// TODO 自动生成的方法存根
		return pdao.selectall(fuid);
	}

	@Override
	public int isenableinsert(String gname) {
		// TODO 自动生成的方法存根
		Photogallery haha=pdao.selectbygname(gname);
		if(haha!=null){
			return 1;
		}
		return 0;
	}

	@Override
	public int insert(Photogallery record) {
		// TODO 自动生成的方法存根
		return pdao.insertT(record);
	}

	@Override
	public void deletebygid(String gid) {
		// TODO 自动生成的方法存根
		pdao.deleteByPrimaryKey(gid);
	}

	@Override
	public Photogallery selectone(String gid) {
		// TODO 自动生成的方法存根
		return pdao.selectByPrimaryKey(gid);
	}

}
