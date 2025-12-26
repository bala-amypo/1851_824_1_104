@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository deviceRepo;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceCatalogItem createItem(DeviceCatalogItem item) {

        deviceRepo.findByDeviceCode(item.getDeviceCode())
                .ifPresent(d -> {
                    throw new BadRequestException("exists");
                });

        if (item.getMaxAllowedPerEmployee() == null || item.getMaxAllowedPerEmployee() <= 0) {
            throw new BadRequestException("maxAllowedPerEmployee");
        }

        return deviceRepo.save(item);
    }

    @Override
    public DeviceCatalogItem updateActiveStatus(Long id, boolean active) {
        DeviceCatalogItem item = deviceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));

        item.setActive(active);
        return deviceRepo.save(item);
    }

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return deviceRepo.findAll();
    }
}
