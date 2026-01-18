db.inventory.find(
	{tags: {$all : ['A', 'B']}}, //query
	{tags:1} // projection
)

db.inventory.find(
	{tags: ['A', 'B']}, //tags: {$eq: ['A', 'B']}
	{tags:1} // projection
)

db.inventory.find(
	{tags: {$eq: ['A', 'B']}}, 
	{tags:1} 
)

db.inventory.find(
{qty > 5})


expression: $and:[{$eq: ['%qty',40]] :return true/false

db.bios.find({'name.first': {$regex: /o/}})