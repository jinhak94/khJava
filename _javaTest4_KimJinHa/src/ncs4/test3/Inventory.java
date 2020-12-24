package ncs4.test3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {
	private String productName;	//상품명
	private Date putDate;		//입고일	
	private Date getDate;		//출고일
	private int putAmount;		//입고수량
	private int getAmount;		//출고수량
	private int inventoryAmount;//재고수량
	
	public Inventory() {
		
	}

	public Inventory(String productName, Date putDate, int putAmount) {
		this.productName = productName;
		this.putDate = putDate;
		this.putAmount = putAmount;
		inventoryAmount = putAmount;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getPutDate() {
		return putDate;
	}

	public void setPutDate(Date putDate) {
		this.putDate = putDate;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	public int getPutAmount() {
		return putAmount;
	}

	public void setPutAmount(int putAmount) {
		this.putAmount = putAmount;
	}

	public int getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(int getAmount) throws AmountNotEnough{
		this.getAmount = getAmount;
		if(putAmount < getAmount) {
			throw new AmountNotEnough("현재 재고가 부족합니다."
					+ "재고수량 확인하시기 바랍니다.");
		}else {
			inventoryAmount = putAmount - getAmount;
		}
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 ");
		String pstr, gstr;
		if(putDate == null) {
			pstr = null;
		}else {
			pstr = format.format(putDate);
		}
		if(getDate == null) {
			gstr = null;
		}else {
			gstr = format.format(getDate);
		}
		
		return productName + ", \t" + pstr + " 입고, " + 
				putAmount + "개, " + gstr + ", " + getAmount
				+ "개, " + inventoryAmount + "개";
	}
}
