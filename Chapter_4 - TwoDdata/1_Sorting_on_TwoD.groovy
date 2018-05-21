/* 
- This explains the method sorting on twoddata:
Example:
*/
List list = [
    [id:0, firstName: 'Sachin', lastName: 'Tendulkar', age: 40 ],
    [id:1, firstName: 'Sachin', lastName: 'Tendulkar', age: 103 ],
    [id:2, firstName: 'Ajay', lastName: 'Tendulkar', age: 48 ],
    [id:3, firstName: 'Virendra', lastName: 'Sehwag', age: 5 ],
    [id:4, firstName: 'Virendra', lastName: 'Sehwag', age: 50 ],
    [id:5, firstName: 'Sachin', lastName: 'Nayyar', age: 15 ]
]

// Sorting function ()

list.sort { a,b ->
   a.firstName <=> b.firstName ?: a.lastName <=> b.lastName ?: a.age <=> b.age
}*.id

// The output should be a list of the column like structure of id
// [2, 5, 0, 1, 3, 4]
// source : [link](http://www.tothenew.com/blog/groovier-way-of-sorting-over-multiple-fields-in-a-list-of-maps-in-groovy/)
