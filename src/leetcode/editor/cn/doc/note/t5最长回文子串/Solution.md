## 思路
对于一个子串而言，如果它是回文串，并且长度大于2，那么将它首尾的两个字母去除之后，它仍然是个回文串。

> 例如对于字符串ababa，如果我们已经知道bab是回文串，那么ababa一定是一个回文串，因为它首尾两个字母都是a。

根据这样的思路，我们就可以用动态规划的方法解决本题。我们用 P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串（下文表示成 s[i:j]）是否为回文串。那么P(i,j)就有两种情况，一种是true一种是false.我们可以得出状态转移方程：
```shell
P(i,j) = P(i+1, j-1) ^ (s(i) == s(j))
```
## 初始化

计算出动态规划方程后我们要进行状态数组的初始化，初始化时按照如下思路：

- 子串只有一个字符(i==j)时，其一定是回文的
- 子串只有两个字符时，若s[i]==s[j]时，其一定也是回文的，否则不是回文

首先初始化对角线（i==j时），其值皆为1.因为i不能小于j，否则没意思，so数组下半部分无意义

![img](https://zhaopy.oss-cn-beijing.aliyuncs.com/markdown/202207291437665.png)

计算完一个字符后，我们初始化两个字符的，原理也比较简单，假设初始化完成后结果如下（没有回文）：

![img](https://zhaopy.oss-cn-beijing.aliyuncs.com/markdown/202207291439828.png)

至此，初始化完成。

## 计算值

按照状态方程可以看出，从长度为3个元素的位置开始，P(i,j)的值依赖于其左下角的计算结果，因此我们可以从第i-2行倒着计算，当然也可以根据长度正着计算，总之就是一个原则：当前节点的值依赖于左下角的值，因此，左下角的值必须优先于当前值计算。

![img](https://zhaopy.oss-cn-beijing.aliyuncs.com/markdown/202207291442163.png)

总体代码思路：

```scala
  def longestPalindrome(s: String): String = {
    /*
    * 计算状态数组分为三步：
    * 1. 构建一个二维动态数组,然后定义status[x][y]=z表示子串[x:y]，z==1表示为回文子串，z==0表示非回文子串
    * 2. 确定状态转换方程：基本思想为若子串[x:y]为回文子串，则若s[x-1] == s[y+1]，则[x-1:y+1]也为回文子串.
    * 3. 确定初始值：a. 子串只有一个字符(x==y)时，其一定是回文的。 b 子串只有两个字符时，若s[x]==s[y]，则其一定是回文的，否则不是回文
    * 如何根据状态数组确定最长回文子串：
    * 构建的时候每次都记录当前记录到的最大的子串的开始和技术索引
    * */
    if (s.length <= 1) {
      return s
    }
    if (s.length == 2) {
      return String.valueOf(if (s.charAt(0) == s.charAt(1)) s else s(0))
    }
    val status = Array.fill(s.length, s.length)(false)

    var maxI = 0
    var maxLen = 1
    /* 初始化开始 */
    for (i <- 0 until s.length - 1) {
      // 本身必定回文，且长度为1
      status(i)(i) = true
      // 两个字符仅需要比较元素是否相同
      if (s.charAt(i) == s.charAt(i + 1)) {
        status(i)(i + 1) = true
        maxLen = 2
        maxI = i
      }
    }
    status(s.length - 1)(s.length - 1) = true
    /* 初始化结束 */
    for (i <- (0 until s.length - 2).reverse) {
      for (j <- i + 2 until s.length) {
        val lastStatusV = status(i+1)(j-1)
        // i == j, 且上一状态为回文子串
        if (s.charAt(i) == s.charAt(j) && lastStatusV) {
          status(i)(j) = true
          // 计算新长度
          val newLen = j - i + 1
          if (newLen > maxLen) {
            maxLen = newLen
            maxI = i
          }
        } else {
          status(i)(j) = false
        }
      }
    }

    //for (line <- status) {
    //  for (s <- line) {
    //    print(s"$s ")
    //  }
    //  println()
    //}
    s.substring(maxI, maxI + maxLen)
  }
```