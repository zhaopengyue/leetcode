<p>给定一个字符串&nbsp;<code>s</code><strong>&nbsp;</strong>和一些 <strong>长度相同</strong> 的单词&nbsp;<code>words</code><strong> 。</strong>找出 <code>s</code><strong> </strong>中恰好可以由&nbsp;<code>words</code><strong> </strong>中所有单词串联形成的子串的起始位置。</p>

<p>注意子串要与&nbsp;<code>words</code><strong> </strong>中的单词完全匹配，<strong>中间不能有其他字符 </strong>，但不需要考虑&nbsp;<code>words</code><strong>&nbsp;</strong>中单词串联的顺序。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "barfoothefoobarman", words = ["foo","bar"]
<strong>输出：</strong><span><code>[0,9]</code></span>
<strong>解释：</strong>
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
<span><code><strong>输出：</strong>[]</code></span>
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
<strong>输出：</strong>[6,9,12]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s</code> 由小写英文字母组成</li> 
 <li><code>1 &lt;= words.length &lt;= 5000</code></li> 
 <li><code>1 &lt;= words[i].length &lt;= 30</code></li> 
 <li><code>words[i]</code>&nbsp;由小写英文字母组成</li> 
</ul>

<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 799</li><li>👎 0</li></div>