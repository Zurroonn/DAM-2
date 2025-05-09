import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBSingletonBiblioteca1 {
    private static MongoDBSingletonBiblioteca1 instance;

    private final MongoClient mongoClient;
    private final MongoDatabase database;

    // Constructor privado
    private MongoDBSingletonBiblioteca1() {
        this.mongoClient = MongoClients.create("mongodb://localhost:27017"); // URL de MongoDB
        this.database = mongoClient.getDatabase("mibasedatos"); // Base de datos donde está la colección
    }

    // Método estático para obtener la instancia única
    public static synchronized MongoDBSingletonBiblioteca1 getInstance() {
        if (instance == null) {
            instance = new MongoDBSingletonBiblioteca1();
        }
        return instance;
    }

    // Método para obtener una colección
    public MongoCollection<Document> getCollection(String collectionName) {
    	
    	if (database!=null) {
			return database.getCollection(collectionName);
		}else {
        throw new IllegalStateException("no se establecio conexion");
		}
    }

    // Cerrar la conexión
    public void close() {
        mongoClient.close();
    }
}
