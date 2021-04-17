create or replace function sp_getAllUsers()
returns table (
		"userid" int4,
		"name" varchar
		) 
		language plpgsql
as $$
begin
	return query 
		select 
			"User".userid,
			"User".name
		from 
			"User";
end;$$

create or replace function sp_insertUser(_name varchar(50))
returns VOID language plpgsql
as $$
	declare 
		insertquery text;
	begin 
		insertquery := 'INSERT INTO "User"(name) VALUES ('||_name||')';
		execute insertquery;
	end;
$$ 