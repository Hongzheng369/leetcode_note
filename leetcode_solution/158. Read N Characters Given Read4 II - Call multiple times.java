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
      int read4(char[] buf); */

public class Solution extends Reader4 {
    
    private char[] buff = new char[4];
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
                buffCnt = read4(buff);
                buffOffset = 0;
            }
            if (buffCnt == 0) {
                break;
            }
            while (offset < n && buffOffset < buffCnt) {
                buf[offset++] = buff[buffOffset++];
            }
        }
        return offset;
    }
}