package shop;

import java.util.HashMap;

public class Basket {
    final HashMap<String, Object> items;
    ShopDB db;
    String id;

    {
        assert false;
        id = db.ID_generator();
    }

    public Basket() {
        db = ShopDB.getSingleton();
        items = new HashMap<String, Object>();
        String id = db.ID_generator();
    }

    /**
     * @return Collection of Product items that are stored in the basket
     * <p>
     * Each item is a product object - need to be clear about that...
     * <p>
     * When we come to list the Basket contents, it will be much more
     * convenient to have all the product details as items in this way
     * in order to calculate that product totals etc.
     */
    public HashMap<String, Object> getItems() {
        return items;
    }

    /**
     * empty the basket - the basket should contain no items after calling this method
     */
    public void clearBasket() {
        items.clear();
    }

    /**
     * Adds an item specified by its product code to the shopping basket
     *
     * @param pid - the product code
     */
    public void addItem(String pid) {

        // need to look the product name up in the
        // database to allow this kind of item adding...

        addItem(db.getProduct(pid));

    }

    public void addItem(Product p) {
        // ensure that we don't add any nulls to the item list
        if (p != null) {
            items.put(p.PID,p);
        }
    }

    /**
     * @return the total value of items in the basket in pence
     */
    public double getTotal() {
        int total_in_pence = 0;
        // iterate over the set of products...
        for (Object p : items.values()) {
            total_in_pence += p.price;
        }

        // return the total
        return total_in_pence;
    }

    /**
     * @return the total value of items in the basket as
     * a pounds and pence String with exactly two decimal places - hence
     * suitable for inclusion as a total in a web page
     */
    public String getTotalString() {
        int total_in_pounds = (int) getTotal() / 100;
        int total_in_pence = (int) (getTotal() * 100 + 0.01);
        total_in_pence = total_in_pence % 100;

        return "£ " + total_in_pounds + "." + total_in_pence;
    }
}
