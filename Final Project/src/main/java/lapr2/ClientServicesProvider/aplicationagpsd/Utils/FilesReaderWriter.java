package lapr2.ClientServicesProvider.aplicationagpsd.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.AffectedTo;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Appliance;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Category;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Client;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Company;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.CompleteWork;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ExecutionOrder;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.GeographicArea;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Invoice;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Rating;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.Service;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvider;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.ServiceProvisionRequest;
import lapr2.ClientServicesProvider.aplicationagpsd.Model.User;

/**
 *
 * @author Tiago Ribeiro (1181444)
 */
public class FilesReaderWriter {
    
    /**
     * Saves a binary file where the Clients will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveClientRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getClientRecord().getClientList());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Client record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Clients are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsClientRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<Client> clientList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                clientList = (ArrayList<Client>) in.readObject();
                Company.getClientRecord().setClientList(clientList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no registered Clients.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Service Providers will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveServiceProviderRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getServiceProviderRecord().getServiceProvidersList());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Service Provider record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Service Providers are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsServiceProviderRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<ServiceProvider> serviceProviderList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                serviceProviderList = (ArrayList<ServiceProvider>) in.readObject();
                Company.getServiceProviderRecord().setServiceProviderList(serviceProviderList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no registered Service Providers.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Service Provision Requests will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveServiceProvisionRequestRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getRequestRecord().getServProvReqList());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Service Provision Requests record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Service Provision Requests are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsServiceProvisionRequestRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<ServiceProvisionRequest> serviceProvisionRequestList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                serviceProvisionRequestList = (ArrayList<ServiceProvisionRequest>) in.readObject();
                Company.getRequestRecord().setServProvReqList(serviceProvisionRequestList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no service provision requests in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Geographic Areas will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveGeographicAreasRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getGeographicAreasRecord().getLstGeographicAreas());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Geographic Areas record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Geographic Areas are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsGeographicAreasRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<GeographicArea> geographicAreaList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                geographicAreaList = (ArrayList<GeographicArea>) in.readObject();
                Company.getGeographicAreasRecord().setLstGeographicAreas(geographicAreaList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no geographic areas specified in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Categories will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveCategoryRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getCategoryRecord().getListOfCategories());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Categories record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Categories are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsCategoryRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<Category> categoriesList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                categoriesList = (ArrayList<Category>) in.readObject();
                Company.getCategoryRecord().setListOfCategories(categoriesList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no Categories specified in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Services will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveServicesRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getServiceRecord().getServices());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Services record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Services are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsServicesRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<Service> servicesList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                servicesList = (ArrayList<Service>) in.readObject();
                Company.getServiceRecord().setServices(servicesList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no Services specified in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Appliances will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveAppliaceRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getApplianceRecord().getListOfAppliances());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Appliances record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Appliances are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsApplianceRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<Appliance> appliancesList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                appliancesList = (ArrayList<Appliance>) in.readObject();
                Company.getApplianceRecord().setAppliances(appliancesList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no Appliances in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the CompleteWorks will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveCompleteWorkRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getCompleteWorkRecord().getLstCompleteWorks());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Complete Works record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the CompleteWorks are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsCompleteWorkRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<CompleteWork> completeWorkList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                completeWorkList = (ArrayList<CompleteWork>) in.readObject();
                Company.getCompleteWorkRecord().setCompleteWorksList(completeWorkList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no Complete Works in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the AffectedTo objects will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveAffectedToRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getAffectedToRecord().getAffectationsList());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the 'Affected To' record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the AffectTo objects are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsAffectedToRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<AffectedTo> affectedToList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                affectedToList = (ArrayList<AffectedTo>) in.readObject();
                Company.getAffectedToRecord().setAffectationsList(affectedToList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no 'AffectTo' objects in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Execution Orders will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveExecutionOrderRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getExecutionOrderRecord().getExecutionOrdersList());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Execution Orders record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Execution Orders are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsExecutionOrderRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<ExecutionOrder> executionOrderList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                executionOrderList = (ArrayList<ExecutionOrder>) in.readObject();
                Company.getExecutionOrderRecord().setExecutionOrdersList(executionOrderList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no Execution Orders in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Invoices will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveInvoiceRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getInvoiceRecord().getLstInvoices());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Invoices record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Invoices are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsInvoiceRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<Invoice> invoiceList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                invoiceList = (ArrayList<Invoice>) in.readObject();
                Company.getInvoiceRecord().setInvoiceList(invoiceList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no Invoices in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the Ratings will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveRatingRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getRatingsRecord().getListOfRatings());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Ratings record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the Invoices are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsRatingRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<Rating> ratingsList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                ratingsList = (ArrayList<Rating>) in.readObject();
                Company.getRatingsRecord().setRatingList(ratingsList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no Rating in the system.\n\n");
            return false;
        }
    }
    
    /**
     * Saves a binary file where the User will be serialized
     * @param fileName file name to be saved
     * @return true, if the file is saved with success
     *         false, if the file wasn't saved
     */
    public boolean saveUserRecordBinaryFile(String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                out.writeObject(Company.getUserRecord().getUserList());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("It was not possible to save the Users record file.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    } 
    
    /**
     * Reads the binary file where the User are serialized
     * @param fileName file name to be saved
     * @return true, if the file was read with success
     *         false, if it wasn't possible to read
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean readsUserRecordBinaryFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<User> usersList;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                usersList = (ArrayList<User>) in.readObject();
                Company.getUserRecord().setUsersList(usersList);
            } finally {
                in.close();
            }
            return true;
        } catch (ClassNotFoundException|IOException ex) {
            System.out.println("There are no User in the system.\n\n");
            return false;
        }
    }
}
