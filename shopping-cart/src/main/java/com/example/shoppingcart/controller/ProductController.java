@Controller
@RequestMapping("/products")
public class ProductController {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Sản phẩm 1", "hoa1.jpg", 350000));
        productList.add(new Product(2, "Sản phẩm 2", "hoa2.jpg", 400000));
        productList.add(new Product(3, "Sản phẩm 3", "hoa3.jpg", 500000));
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productList);
        return "product/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product p = productList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        model.addAttribute("product", p);
        return "product/detail";
    }
}
