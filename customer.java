package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.NonReadableChannelException;

import javafx.collections.ObservableList;
import application.Bill;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

public class customer implements Initializable {
	private Rectangle recss = new Rectangle();
	private Parent rootParent;
	@FXML
	private Rectangle drinkRec, fastFoodRec, europeRec, asianRec, creamRec, cakeRec, vegetRec, homeRec;
	@FXML
	private Text drinkText, fastfoodText, europeText, asianText, creamText, cakeText, vegetText;
	@FXML
	private ImageView drinkImg, fastFoodImg, europeImg, asianImg, creamImg, cakeImg, vegetImg;
	
	private Color color;
	@FXML
	private TableView<Bill> billTable;
	@FXML
	private TableColumn<Bill, String> idColumm;
	@FXML
	private TableColumn<Bill, String> nameFoodColumm;
	@FXML
	private TableColumn<Bill, String> priceColumm;
	@FXML
	private TableColumn<Bill, String> amountColumm;
	@FXML
	private TableColumn<Bill, String> totalColumm;
	@FXML
	private AnchorPane root1;
	
	@FXML
	private Pagination pagination;
	@FXML
	private Label nameOfFood;
	@FXML
	private Label price;
	private interact testInteract = new interact();
	private int idFirst = 0;
	private int totalBill = 0;
	private ObservableList<Bill> dataList ;
	private PropertyValueFactory<Bill, Integer> testFactory = new PropertyValueFactory<>("id");
	@Override
	public void initialize(URL location, ResourceBundle resources ) {
		try {
			rootParent = FXMLLoader.load(getClass().getResource("IntroBox.fxml"));
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(96);
			root1.getChildren().add(rootParent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataList = FXCollections.observableArrayList();
		idColumm.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Bill,String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Bill, String> p){
				return (ObservableValue<String>) p.getValue().getIdProperty();
			}
		});
		nameFoodColumm.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Bill,String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Bill, String> p){
				return (ObservableValue<String>) p.getValue().getNameProperty();
			}
		});
		priceColumm.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Bill,String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Bill, String> p){
				return (ObservableValue<String>) p.getValue().getPriceProperty();
			}
		});
		amountColumm.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Bill,String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Bill, String> p){
				return (ObservableValue<String>) p.getValue().getAmountProperty();
			}
		});
		totalColumm.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Bill,String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Bill, String> p){
				return (ObservableValue<String>) p.getValue().getTotalProperty();
			}
		});
		billTable.setItems(dataList);
	}
	public void Init(ArrayList<String> a) {
		pagination.setPageCount(a.size());
		   pagination.setPageFactory((Callback<Integer, Node>) new Callback<Integer, Node>() {
		       public Node call(Integer pageIndex) {
		    	   //pageIndex = a.size();
		    	   int b = pageIndex + 1;
		    	   nameOfFood.setText("Food number: " + b);
		           VBox box = new VBox(5);
		           Image testImage = new Image(getClass().getResourceAsStream(a.get(pageIndex)));
		           
//		           ImageView[] imgView = new ImageView[10];
// 		           for (int i = 0; i < pageIndex + 10; i++) {
// 		        	   imgView[i] = new ImageView(testImage);
// 		        	   imgView[i].setFitWidth(20);
// 		        	   imgView[i].setFitHeight(20);
// 		        	   imgView[i].setSmooth(true);
// 		        	   imgView[i].setCache(true);
//		               box.getChildren().add(imgView[i]);
//		           }
		           ImageView imgView2 = new ImageView(testImage);
		           imgView2.setFitHeight(400);
		           imgView2.setFitWidth(710);
		           box.getChildren().add(imgView2);
		           return box;
		       }
		   });
	}
// Test for cake
	public void Init1(Food a) {
		pagination.setPageCount(a.linkImg.size());
		   pagination.setPageFactory((Callback<Integer, Node>) new Callback<Integer, Node>() {
		       public Node call(Integer pageIndex) {
		    	   nameOfFood.setText(a.nameFood.get(pageIndex));
		    	   price.setText(a.priceFood.get(pageIndex));
		           VBox box = new VBox(5);
		           Image testImage = new Image(getClass().getResourceAsStream(a.linkImg.get(pageIndex)));
		           
//		           ImageView[] imgView = new ImageView[10];
// 		           for (int i = 0; i < pageIndex + 10; i++) {
// 		        	   imgView[i] = new ImageView(testImage);
// 		        	   imgView[i].setFitWidth(20);
// 		        	   imgView[i].setFitHeight(20);
// 		        	   imgView[i].setSmooth(true);
// 		        	   imgView[i].setCache(true);
//		               box.getChildren().add(imgView[i]);
//		           }
		           ImageView imgView2 = new ImageView(testImage);
		           imgView2.setFitHeight(400);
		           imgView2.setFitWidth(710);
		           box.getChildren().add(imgView2);
		           return box;
		       }
		   });
	}
//end Test
	@FXML
	public void hoverDrink(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			drinkRec.setOpacity(1);
		}
		else {
			drinkRec.setOpacity(0);
		}
	}
	@FXML
	public void hoverFastFood(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			fastFoodRec.setOpacity(1);
		}
		else if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(testInteract.getFood());
			root1.getChildren().remove(rootParent);
		}
		else {
			fastFoodRec.setOpacity(0);
		}
	}
	@FXML
	public void hoverEurope(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			europeRec.setOpacity(1);
		}
		else if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(testInteract.getEurope());
			root1.getChildren().remove(rootParent);
		}
		else {
			europeRec.setOpacity(0);
		}
	}
	@FXML
	public void hoverAsian(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			asianRec.setOpacity(1);
		}
		else if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(testInteract.getAsian());
			root1.getChildren().remove(rootParent);
		}
		else {
			asianRec.setOpacity(0);
		}
	}
	@FXML
	public void hoverCream(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			creamRec.setOpacity(1);
		}
		else if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init(testInteract.getCream());
			root1.getChildren().remove(rootParent);
		}
		else {
			creamRec.setOpacity(0);
		}
	}
	@FXML
	public void hoverCake(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			cakeRec.setOpacity(1);
		}
		else if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Init1(testInteract.getCake());
			root1.getChildren().remove(rootParent);
		}
		else {
			cakeRec.setOpacity(0);
		}
	}
	@FXML
	public void hoverVeget(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			vegetRec.setOpacity(1);
		}
		else {
			vegetRec.setOpacity(0);
		}
	}
//	@FXML
//	public void hoverDrink(MouseEvent e) {
//		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
//			drinkRec.setOpacity(0.3);
//			System.out.println("up");
//		}
//		else {
//			drinkRec.setOpacity(0);
//			drinkRec.setStroke(Color.TRANSPARENT);
//		}
//	}
//	@FXML
//	public void hoverDrink(MouseEvent e) {
//		if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
//			drinkRec.setOpacity(0.3);
//			System.out.println("up");
//		}
//		else {
//			drinkRec.setOpacity(0);
//			drinkRec.setStroke(Color.TRANSPARENT);
//		}
//	}
	public void homeHover(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			try {
				rootParent = FXMLLoader.load(getClass().getResource("IntroBox.fxml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			rootParent.setLayoutX(228);
			rootParent.setLayoutY(96);
			root1.getChildren().add(rootParent);
			System.out.println("A");
		}
		else if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			homeRec.setOpacity(1);
		}
		else {
			homeRec.setOpacity(0);
		}
	}
	public void Close(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			Stage stage = (Stage) root1.getScene().getWindow();
			stage.close();
		}
		else if(e.getEventType() == MouseEvent.MOUSE_ENTERED) {
			
		}
		else {
			
		}
	}
	public void choseFood(MouseEvent e) {
		if(e.getEventType() == MouseEvent.MOUSE_CLICKED) {
			System.out.print("Click");
			Bill bill = new Bill();
			bill.setId(String.valueOf(++idFirst));
			bill.setName(nameOfFood.getText());
			bill.setPrice(price.getText());
			bill.setAmount("1");
			bill.setTotal(price.getText());
			dataList.add(bill);
			billTable.setItems(dataList);
		}
	}
}
