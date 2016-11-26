package util;

public class Pageinfo {
	private int offset;  
    private int max;  
    private String sql; 
    private String tablename;
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public Pageinfo(){
		
	}
	public Pageinfo(int offset, int max, String tablename) {
		super();
		this.offset = offset;
		this.max = max;
		this.tablename = tablename;
		this.sql = "select * from (select t.*, ROWNUM RM from (select * from "+ tablename+") t where ROWNUM<=" + this.max  
                + " ) where RM> " + this.offset; 
	}
    
}
