from Actions.searchAction import SearchActions


def test_product_search(driver):

    search = SearchActions(driver)
    search.enter_search_product("MacBook")

    search.click_search()
    results = search.get_search_results()

    print("Search Results:", results)
    expected_product = "MacBook"

    assert any(
        expected_product.lower() in product.lower()
        for product in results
    ), "Expected product not found in search results"