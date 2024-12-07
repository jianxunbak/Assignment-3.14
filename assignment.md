## Assignment

### Brie|f

Create test cases for the following scenarios for `CatalogueController` in `CatalogueControllerTest.java`:

| Scenario # | Given                       | When             | Then                                    |
| ---------- | --------------------------- | ---------------- | --------------------------------------- |
| 1          | Catalogue Id is not found   | method is called | return status 404 not found             |
| 2          | Catalogue Id is present     | method is called | return status 200 ok and response body  |
| 3          | Database connection is lost | method is called | return 500 status internal server error |

### Challenge

If you have completed the above, challenge yourself by working on creating unit tests for `ServiceForTest.java` for the following scenarios:
Write your unit tests in `TestServiceForTest.java`.

| Scenario # | Given                | When             | Then             |
| ---------- | -------------------- | ---------------- | ---------------- |
| 1          | Password length is 8 | method is called | return 8         |
| 2          | Password length is 9 | method is called | return 9         |
| 3          | Password length is 7 | method is called | throws exception |

### Submission

- Submit the URL of the GitHub Repository that contains your work to NTU black board.
- Should you reference the work of your classmate(s) or online resources, give them credit by adding either the name of your classmate or URL.

### References

_Example of Referencing Classmate_

Referenced the code block below from Terence.

```js
function printMe() {
  console.log("I am a reference example");
}
```

_Example of Referencing Online Resources_

- https://developer.mozilla.org/en-US/
- https://www.w3schools.com/html/
- https://stackoverflow.com/questions/14494747/how-to-add-images-to-readme-md-on-github
