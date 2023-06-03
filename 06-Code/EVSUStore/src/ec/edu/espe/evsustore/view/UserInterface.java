package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Inventory;
import ec.edu.espe.evsustore.model.JsonFileManager;
import ec.edu.espe.evsustore.model.SalesRegister;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class UserInterface {
    Scanner scanner = new Scanner(System.in);   
    InputHandler keyboardInput = new InputHandler();
    
    ArrayList<HardwareComponent> hardwareComponents = new ArrayList<>();
    ArrayList<Clothing> clothings = new ArrayList<>();
    
    Inventory inventory = new Inventory(hardwareComponents, clothings);
    JsonFileManager inventoryFile = new JsonFileManager("Inventory");
    Catalog catalog = new Catalog(inventory);
    SalesRegister salesRegister = new SalesRegister();

    public UserInterface() {
    }
    
    public void selecOption(){
        PurchaseInterface purchaseInterface = new PurchaseInterface();
        while (true) {

            showMenu();
            
            int option = keyboardInput.nextInt();
            switch (option) {
                case 1 -> {
                    
                    purchaseInterface.handlePurchase();
                   
                }
                case 2 -> {
                    inventoryFile.updateInventory(inventory);
                    catalog.displayProducts();

                }
                case 3 -> {
                    
                    System.out.println("Hacer compra");
                }
                case 4 -> {
                    purchaseInterface.showRegisterOfPurchases();
                            
                    System.out.println("Ver registro");
                }
                case 5 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }
    
    public void showMenu() {
        
        System.out.println("*********************************************************");
        System.out.println("                      EVSU STORE                         ");
        System.out.println("*********************************************************");
        System.out.println("");
        System.out.println("1.Hacer compra ");
        System.out.println("2.Ver productos ");
        System.out.println("3.Realizar venta");
        System.out.println("4.Ver registros de compras");
        System.out.println("5.Salir");
        System.out.println("");
        System.out.println("Escoja una opcion");
        System.out.println("");
        System.out.println("*********************************************************");
    }
    
    public void messagePurchase(){
        System.out.println("Se realizo la compra del siguiente producto: ");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public JsonFileManager getInventoryFile() {
        return inventoryFile;
    }

    public void setInventoryFile(JsonFileManager inventoryFile) {
        this.inventoryFile = inventoryFile;
    }
}
