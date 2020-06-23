package co.rh.beans.model;

import java.lang.reflect.Field;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IGroupDAO {
	
	
	
	String tableName = "Groups";    
	 
    //
	@Select("select * from "+tableName+" where id = 1")
	Groups selectById();

	@Select("select * from "+tableName+" where id = #{id} ")
	Groups selectId(@Param("id") int id);

}
