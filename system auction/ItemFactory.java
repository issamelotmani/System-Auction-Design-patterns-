class ItemFactory {
    public static Item createItem(String name, String description, User owner) {
        return new Item(name, description,owner);
    }
}
