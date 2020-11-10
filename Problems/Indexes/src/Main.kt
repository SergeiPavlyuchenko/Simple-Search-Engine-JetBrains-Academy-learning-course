fun solution(products: List<String>, product: String) {
    /* products.indices
            .filter { products[it] == product }
            .forEach { print("$it ")}*/
    products.forEachIndexed { i, prod -> if (prod == product) print("$i ") }
}
