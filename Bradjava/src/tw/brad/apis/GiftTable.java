package tw.brad.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiftTable extends JTable{
	private GiftDB db;
	public GiftTable() {
//		super(40,4);   //讓它顯示出來而已
		try {
			db=new GiftDB(); //connection建立成功
			db.query();
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
		
		
		GiftModel model =new GiftModel();
		model.setColumnIdentifiers(db.getFieldName());
		setModel(model);
	}
	
	public void delRow() {
		try {
		db.delData(getSelectedRow());
		repaint();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	

	private class GiftModel extends DefaultTableModel{
		//右鍵->source->Override選擇->getRowCount.getColumnCount
		@Override
		public int getRowCount() {
			
			return db.getRows();
		}

		@Override
		public int getColumnCount() {
			
			return db.getCols();
		}

		@Override 
		public Object getValueAt(int row, int column) {			
//			return String.format("%s %dx%d","Brad",row,column);
			return db.getData(row, column);
		}
				

		@Override
		public void setValueAt(Object aValue, int row, int column) {			
			db.updateData((String)aValue, row, column);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			
			return column!=0; //不等於0才能修改
		}
		
		
	}
	
	
	
}
