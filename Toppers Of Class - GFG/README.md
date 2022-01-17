# Toppers Of Class
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">There is a class of <strong>N</strong> students and the task is to find the top <strong>K</strong> marks scorers. You need to print the index of the toppers of the class which will be same as the index of the student in the input array (use 0-based indexing). First print the index of the students having highest marks then the students with second highest and so on. If there are more than one students having same marks then print their indices in ascending order.Suppose k = 2 and the students having highest marks have indices 0 and 5 and students having second highest marks have indices 6 and 7 then output will be 0 5 6 7.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>N=5 K=3
arr[] = { 2, 2, 1, 3, 1 }
<strong>Output:</strong> 3 0 1 2 4
<strong>Explanation</strong>: Topper with 3 marks is present 
at 3rd index, 2 marks is present at 0<sup>th</sup> 
index and next at 1<sup>st</sup> index. 1 marks is present 
at 2 and 4.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>N=4 K=1
arr[] = { 1, 2, 3, 4 } 
<strong>Output:</strong> 3
<strong>Explanation</strong>: The highest marks is at index 3.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
Since this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function <strong>kTop</strong>() that takes <strong>array A and integer N</strong>&nbsp;as parameters and change the given array according to the given conditions. You do not have to return anything</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(NlogN).<br>
<strong>Expected Auxiliary Space:</strong> O(1).</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>6</sup><br>
1 ≤ M&nbsp;≤ 10<sup>6</sup></span></p>
 <p></p>
            </div>