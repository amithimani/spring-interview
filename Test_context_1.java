@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyTestConfig.class})
public class MyTest {
 
    @Autowired
    private MyService myService;
 
    @Test
    public void testMyService() {
        // Test code using MyService
    }
}
