package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.FileManager;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Inventory;
import ec.edu.espe.evsustore.model.Purchase;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class UserInterface {
    ArrayList <HardwareComponent> hardwareComponents=new ArrayList();
    InputHandler keyboardInput = new InputHandler();
    ArrayList <Clothing> clothings=new ArrayList();
    Scanner scanner = new Scanner(System.in);
    Inventory inventory = new Inventory(hardwareComponents,clothings);
    public void showMenu() {
        
        System.out.println("*********************************************************");
        System.out.println("                      EVSU STORE                         ");
        System.out.println("*********************************************************");
        System.out.println("");
        System.out.println("1.Hacer compra ");
        System.out.println("2.Ver productos ");
        System.out.println("3.Realizar venta");
        System.out.println("4.Ver registors de compras");
        System.out.println("5.Salir");
        System.out.println("");
        System.out.println("Escoja una opcion");
        System.out.println("");
        System.out.println("*********************************************************");
    }
    
    
    public HardwareComponent createPurchase(){
        HardwareComponent purchasedHardwareComponents = new HardwareComponent();
        purchasedHardwareComponents.setId();
        System.out.println("Ingrese el nombre del componente: ");
        purchasedHardwareComponents.setName(keyboardInput.nextLine());
        System.out.println("Ingrese el modelo del componente: ");
        purchasedHardwareComponents.setModel(keyboardInput.nextLine());
        System.out.println("Ingrese el cantidad del componente: ");
        purchasedHardwareComponents.setQuantity(keyboardInput.nextInt());
        System.out.println("Ingrese el costo del componente: ");
        purchasedHardwareComponents.setIndividualCost(keyboardInput.nextDouble());
        System.out.println("Ingrese el precio de venta del componte: ");
        purchasedHardwareComponents.setIndividualPrice(keyboardInput.nextDouble());
        
        System.out.println("Se ha añadido al inventario: \n"+purchasedHardwareComponents);
        
        
        return purchasedHardwareComponents; 
          
    }
    
    public Clothing createPurchaseClothing(){
        Clothing purchaseClothings = new Clothing();
        purchaseClothings.setId();
        System.out.println("Ingrese el nombre del componente: ");
        purchaseClothings.setName(keyboardInput.nextLine());
        System.out.println("Ingrese el modelo del componente: ");
        purchaseClothings.setModel(keyboardInput.nextLine());
        System.out.println("Ingrese el cantidad del componente: ");
        purchaseClothings.setQuantity(keyboardInput.nextInt());
        System.out.println("Ingrese el costo del componente: ");
        purchaseClothings.setIndividualCost(keyboardInput.nextDouble());
        System.out.println("Ingrese el precio de venta del componte: ");
        purchaseClothings.setIndividualPrice(keyboardInput.nextDouble());
        
        System.out.println(purchaseClothings);
        
        
        return purchaseClothings; 
          
    }
    
    public void menuPurchase(){
        System.out.println("*********************************************************");
        System.out.println("                    EVSU STORE-COMPRAS                         ");
        System.out.println("*********************************************************");
        System.out.println("");
        System.out.println("1.Componentes de Hardware ");
        System.out.println("2.Ropa ");
        System.out.println("3.Menu Principal");
        System.out.println("");
        System.out.println("Escoja una opcion");
        System.out.println("");
        System.out.println("*********************************************************");
    }
    
    public void handlePurchase() {
        while (true) {
            menuPurchase();
            int purchaseOption = keyboardInput.nextInt();
            switch (purchaseOption) {
                case 1 -> {
                    Purchase purchase = new Purchase(hardwareComponents,clothings);
                    purchase.toPurchaseHardwareComponents(hardwareComponents,createPurchase());
                    System.out.println(purchase);
                }
                case 2 -> {
                    Purchase purchase = new Purchase(hardwareComponents,clothings);
                    purchase.toPurchaseClothing(clothings,createPurchaseClothing());
                    System.out.println(purchase);
                }
                case 3 -> {
                    selecOption();
                }
                default -> {
                    System.out.println("Opción invalida");
                }
            }
            System.out.println("¿Deseas hacer otra compra? (S/N)");
            String continueShopping = keyboardInput.next().toLowerCase();

            if (!continueShopping.equals("s")) {
                break;
            }
        }
    }
    
    public void selecOption(){
        while (true) {
            Purchase purchase=new Purchase(hardwareComponents,clothings);
            FileManager jsonFile = new FileManager();
            jsonFile.setFileName("TEST1JSON");
            showMenu();
            
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
<<<<<<< HEAD
                    
                    
=======
                    handlePurchase();
                    jsonFile.write(inventory);             
                    

>>>>>>> ffb17918babd33cff19c11db7e8eede8e5066702
                    
                }
                case 2 -> {
                    
                   /* List<Triangle> triangles = fileHandler.readData();
                    for (Triangle t : triangles) {
                        System.out.println("Base: " + t.getBase() + ", Height: " + t.getHeight() + ", Side1: " + t.getSideOne()
                                + ", Side2: " + t.getSideTwo() + ", Side3: " + t.getSideThree()
                                + ", Área: " + t.calculateArea() + ", Perímetro: " + t.calculatePerimeter());
                    }*/
                    System.out.println("Ver producto");
                   
                }
                case 3 -> {
                    
                    System.out.println("Hacer compra");
                }
                case 4 -> {
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
    
   
}
