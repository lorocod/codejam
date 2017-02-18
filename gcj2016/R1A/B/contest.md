## Problem B. Rank and File

<div id="dsb-problem-content-div1" class="dsb-problem-content-div" style="width: 40em;"><h3>Problem</h3>
<p>
When Sergeant Argus's army assembles for drilling, they stand in the shape of
an <b>N</b> by <b>N</b> square grid, with exactly one soldier in each cell.
Each soldier has a certain height.
</p><p>
Argus believes that it is important to keep an eye on all of his soldiers at
all times. Since he likes to look at the grid from the upper left, he requires
that:
</p>
<ul>
<li>Within every row of the grid, the soldiers' heights must be in strictly
increasing order, from left to right.
</li><li>Within every column of the grid, the soldiers' heights must be in strictly
increasing order, from top to bottom.
</li></ul>
<p>
Although no two soldiers in the same row or column may have the same height,
it is possible for multiple soldiers in the grid to have the same height.
</p>
<p>
Since soldiers sometimes train separately with their row or their column, Argus
has asked you to make a report consisting of 2*<b>N</b> lists of the soldiers'
heights: one representing each row (in left-to-right order) and column (in
top-to-bottom order). As you surveyed the soldiers, you only had small pieces
of paper to write on, so you wrote each list on a separate piece of paper.
However, on your way back to your office, you were startled by a loud bugle
blast and you dropped all of the pieces of paper, and the wind blew one away
before you could recover it! The other pieces of paper are now in no particular
order, and you can't even remember which lists represent rows and which
represent columns, since you didn't write that down.
</p>
<p>
You know that Argus will make you do hundreds of push-ups if you give him an
incomplete report. Can you figure out what the missing list is?
</p>

<h3>Input</h3>
<p>
The first line of the input gives the number of test cases, <b>T</b>. <b>T</b>
test cases follow. Each consists of one line with an integer <b>N</b>, followed
by 2*<b>N</b>-1 lines of <b>N</b> integers each, representing the lists you
have, as described in the statement. It is guaranteed that these lists
represent all but one of the rows and columns from a valid grid, as described
in the statement.
</p>

<h3>Output</h3>
<p>
For each test case, output one line containing <code>Case #x: y</code>, where
<code>x</code> is the test case number (starting from 1) and y is a list of
<b>N</b> integers in strictly increasing order, representing the missing list.
</p>

<h3>Limits</h3>
<p>
1 ≤ <b>T</b> ≤ 50.<br>
1 ≤ all heights ≤ 2500.<br>
The integers on each line will be in strictly increasing order.<br>
It is guaranteed that a unique valid answer exists.<br>
</p>

<h4>Small dataset</h4>
<p>
2 ≤ <b>N</b> ≤ 10.<br>
</p>

<h4>Large dataset</h4>
<p>
2 ≤ <b>N</b> ≤ 50.<br>
</p>


<h3>Sample</h3>
<div class="problem-io-wrapper">
<table>
<tbody><tr>
<td>
<br>
<span class="io-table-header">Input</span>
<br>&nbsp;
</td>
<td>
<br>
<span class="io-table-header">Output</span>
<br>&nbsp;
</td>
</tr>
<tr>
<td>
<pre class="io-content">1
3
1 2 3
2 3 5
3 5 6
2 3 4
1 2 3

</pre>
</td>
<td>
<pre class="io-content">Case #1: 3 4 6

</pre>
</td></tr></tbody></table>
</div>


<p>
In the sample case, the arrangement must be either this:
</p>

1 2 3<br>
2 3 4<br>
3 5 6<br>

<p>
or this:
</p>

1 2 3<br>
2 3 5<br>
3 4 6<br>

<p>
In either case, the missing list is <code>3 4 6</code>.
</p>
</div>
