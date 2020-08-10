/*
158. Read N Characters Given Read4 II - Call multiple times
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function may be called multiple times.



Solution:

The idea is to use an internal buffer and global variables to keep track of the status after each read4().

Since read() can be called multiple times, after one read() call, there might be still some elements left in the internal buffer.

Therefore, in the next read() call, we first check if there are leftovers. If there are remaining elements in the internal buffer, we move them to the current buffer. And then process the next read().
*/
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); 
      File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
char[] buf = new char[4]; // Create buffer with enough space to store characters
read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file


Method read:

By using the read4 method, implement the method read that reads n characters from the file and store it in the buffer array buf. Consider that you cannot manipulate the file directly.

The return value is the number of actual characters read.

Definition of read:

    Parameters:	char[] buf, int n
    Returns:	int

Note: buf[] is destination not source, you will need to write the results to buf[]
 

Example 1:

File file("abc");
Solution sol;
// Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
sol.read(buf, 1); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
sol.read(buf, 2); // Now buf should contain "bc". We read a total of 2 characters from the file, so return 2.
sol.read(buf, 1); // We have reached the end of file, no more characters can be read. So return 0.
Example 2:

File file("abc");
Solution sol;
sol.read(buf, 4); // After calling your read method, buf should contain "abc". We read a total of 3 characters from the file, so return 3.
sol.read(buf, 1); // We have reached the end of file, no more characters can be re
      
      
      */

public class Solution extends Reader4 {
    
    private char[] buffIdx = new char[4];
    private int buffOffset = 0;
    private int buffCnt = 0;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int offset = 0;
        while (offset < n) {
            if (buffOffset == buffCnt) {
                buffCnt = read4(buffIdx);
                buffOffset = 0;
            }
            if (buffCnt == 0) {
                break;
            }
            while (offset < n && buffOffset < buffCnt) {
                buf[offset++] = buffIdx[buffOffset++];
            }
        }
        return offset;
    }
}