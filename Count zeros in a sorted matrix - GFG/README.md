# Count zeros in a sorted matrix
## Easy
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a <strong>N X N&nbsp;</strong>binary Square Matrix where each row and column of the matrix is sorted in ascending order. Find the total number of <strong>zeros</strong> present in the matrix.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>N = 3
A = {{0, 0, 0},
&nbsp;    {0, 0, 1},
&nbsp;    {0, 1, 1}}<strong>
Output: </strong>6
<strong>Explanation: 
</strong>The first, second and third row contains 3, 2 and 1
zeroes respectively.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:
</strong>N = 2
A = {{1, 1},
&nbsp;    {1, 1}}
<strong>Output: </strong>0
<strong>Explanation:
</strong>There are no zeroes in any of the rows.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>countZeros()&nbsp;</strong>which takes a <strong>2D matrix</strong> as input and returns the number occurring only once.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N ).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(1).</span></p>

<p><span style="font-size:18px"><strong>Constraints</strong><br>
0 &lt; &nbsp; <strong>N</strong>&nbsp; &lt;= 10<sup>3</sup><br>
0 &lt;= <strong>A[i]</strong> &lt;= 1</span></p>
 <p></p>
            </div>