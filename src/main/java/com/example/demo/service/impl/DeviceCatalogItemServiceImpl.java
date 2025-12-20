import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.DeviceCatalogItemRepository;

@Service
public class DeviceCatalogItemServiceImpl implements DeviceCatalogItemService {

    @Autowired
    private DeviceCatalogItemRepository repository;

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return repository.findAll(); // fixes the issue
    }
}
