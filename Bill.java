package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Bill {
	private SimpleStringProperty idd ;
	private SimpleStringProperty nameOfFood ;
	private SimpleStringProperty priceOfFood;
	private SimpleStringProperty totalOfBill;
	private SimpleStringProperty amountOfFood;

	public StringProperty getIdProperty() {
		return idd;
	}
	public StringProperty getNameProperty() {
		return nameOfFood;
	}
	public StringProperty getPriceProperty() {
		return priceOfFood;
	}
	public StringProperty getAmountProperty() {
		return amountOfFood;
	}
	public StringProperty getTotalProperty() {
		return totalOfBill;
	}
	public Bill() {
		this.idd = new SimpleStringProperty();
		this.nameOfFood = new SimpleStringProperty();
		this.priceOfFood = new SimpleStringProperty();
		this.amountOfFood = new SimpleStringProperty();
		this.totalOfBill = new SimpleStringProperty();
	}
	public Bill(String id, String nameOfFood, String priceOfFood,String amountOfFood, String totalOfFood) {
		this.idd = new SimpleStringProperty(id);
		this.nameOfFood = new SimpleStringProperty(nameOfFood);
		this.priceOfFood = new SimpleStringProperty(priceOfFood);
		this.amountOfFood = new SimpleStringProperty(amountOfFood);
		this.totalOfBill = new SimpleStringProperty(totalOfFood);
	}
	public void setId(String id) {
		this.idd.set(id);
	}
	public void setName(String name) {
		this.nameOfFood.set(name);
	}
	public void setAmount(String amount) {
		this.amountOfFood.set(amount);
	}
	public void setTotal(String total) {
		this.totalOfBill.set(total);
	}
	public void setPrice(String price) {
		this.priceOfFood.set(price);
	}
//	public ObservableValue<Integer> idProperty() {
//		ObservableValue<Integer> nesObservableValue = new ObservableValue<Integer>() {
//			
//		};
//	}
}
