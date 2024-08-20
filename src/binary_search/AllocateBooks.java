package binary_search;
import java.util.ArrayList;
public class AllocateBooks {

    private static boolean canAllocateBooks(ArrayList<Integer> arr, int n, int m, int pagesAllowedToHold) {
        // mid ---> pagesAllowedToHold
        int studentCount = 1;
        int pagesCount = 0;

        for (int i = 0; i < n; i++) {
            if (pagesCount + arr.get(i) > pagesAllowedToHold) {
                // If adding this book exceeds `mid`, allocate to a new student
                studentCount++;
                pagesCount = arr.get(i); // Reset to the current book's pages

                // if we need more students to hold mid-number of pages, it means, the mid that we have taken
                // is very less (the mid is the max pages held by a student)
                /*
                    Ex: [ 25, 46, 28, 49, 24]
                    m = 4 (students)

                    if we take 49 as max number of pages held (first low value in the possible range when linear search)
                    in the similar manner mid would also hold a value.

                    books held by students would be in the following manner:
                    1 - 25
                    2 - 46
                    3 - 28
                    4 - 49
                    5 - 24

                    Since each book has to be allocated to one student, we required more than m students to get all
                    books allocated - this happened because our mid or assumed value was very small because of which
                    no student could hold more than 1 book.
                    Hence, whenever studentCount > m, eliminate left and move to the right side of the mid

                    Try mid = 71, we will be able to allocate all the books to 4 students (given m)
                 */
                if (studentCount > m) {
                    return false; // Too many students required
                }
            } else {
                pagesCount += arr.get(i); // Continue adding pages to the current student
            }
        }
        return true; // Feasible to allocate books
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {

        if (m > n) return -1;

        int totalPages = 0;
        int maxPages = 0; // if someone can hold maxPage book, others can atleast hold books with lesser pages
        // that's why we didn't go with minimum pages book, because others would then will not be able to
        // hold any other books since we choose the min pages book
        for (int pages : arr) {
            totalPages += pages;
            maxPages = Math.max(maxPages, pages); // Track the maximum book pages
        }

        int low = maxPages; // = this will be when no of students (m) is equal to n (given number of books)
        int high = totalPages;  // = this will be when no of student (m) is 1 which will hold all books

        // Hence, the given m would lie in between these low and high value
        while (low <= high) {
            int mid = (low + high) / 2;

            // means it took <= m students to hold n books, when low > high at this point we would get the
            // result for m students
            if (canAllocateBooks(arr, n, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
