/**
 * 
 */
package org.openoffice.ezodfmenu.comp;

import javax.swing.JComponent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * @author hovik
 *
 */
public class eZPTreeTableModel implements TableModel {

	protected eZPTreeNode treeNode;	

	/**
	 * Constructor
	 * @param Tree node. The list model will be populated by the children of the 
	 * tree node.
	 */
	public eZPTreeTableModel( eZPTreeNode treeNode )
	{
		this.treeNode = treeNode;
	}

	public void addTableModelListener(TableModelListener arg0) {
		// Do nothing.
	}

	public Class<?> getColumnClass( int columnIndex ) {
		switch( columnIndex )
		{
			case 0: return new Object().getClass();
			default:
			case 1:
			case 2:
			case 3:
			case 4: return new String().getClass();
		}
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName( int columnIndex ) {
		switch( columnIndex ){
			default:
			case 0: return "";
			case 1: return "Name";
			case 2: return "Type";
			case 3: return "Created";
			case 4: return "Modified";
		}
	}

	public int getRowCount() {
		return treeNode.getChildCount();
	}

	public Object getValueAt( int rowIndex, int columnIndex ) {
		eZPTreeNode node = treeNode.getChild( rowIndex );
		
		switch( columnIndex ){
			default:
			case 0: return "";
			case 1: return node.getName();
			case 2: return node.getClassName();
			case 3: return node.getPublishedDateTime();
			case 4: return node.getModifiedDateTime();
		}
	}

	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	public void removeTableModelListener(TableModelListener arg0) {
		// Not allowed, do nothing.
	}

	public void setValueAt(Object arg0, int arg1, int arg2) {
		// Not allowed, do nothing.
	}
}
