SELECT *
FROM student t1
     LEFT JOIN person t2 ON t1.id = t2.id
ORDER BY age DESC