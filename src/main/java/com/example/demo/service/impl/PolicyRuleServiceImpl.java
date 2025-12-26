@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository ruleRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {

        ruleRepo.findByRuleCode(rule.getRuleCode())
                .ifPresent(r -> {
                    throw new BadRequestException("Rule code");
                });

        return ruleRepo.save(rule);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return ruleRepo.findAll();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }
}
