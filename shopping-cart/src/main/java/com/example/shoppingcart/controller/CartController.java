@Controller
public class CartController {

    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        model.addAttribute("cart", cart);
        model.addAttribute("total", calculateTotal(cart));
        return "cart/view";
    }

    @PostMapping("/cart/update")
    public String updateCart(@RequestParam int id, @RequestParam int quantity, HttpSession session) {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(id)) {
            cart.get(id).setQuantity(quantity);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeItem(@PathVariable int id, HttpSession session) {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart != null) cart.remove(id);
        return "redirect:/cart";
    }

    private double calculateTotal(Map<Integer, CartItem> cart) {
        if (cart == null) return 0;
        return cart.values().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
}
