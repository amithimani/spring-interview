@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = SecurityTestConfig.class)
public class SecurityTest {
 
    @Autowired
    private MockMvc mockMvc;
 
    @Test
    public void testPublicEndpoint() throws Exception {
        mockMvc.perform(get("/public/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello, World!"));
    }
 
    @Test
    public void testAdminEndpoint() throws Exception {
        mockMvc.perform(get("/admin/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello, Admin!"));
    }
 
    @Test
    public void testUnauthorizedEndpoint() throws Exception {
        mockMvc.perform(get("/secure/hello"))
            .andExpect(status().isUnauthorized());
    }
}
