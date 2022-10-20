insert into user_details(id,birth_date,name)
values(10001, current_date(),'ketty');

insert into user_details(id,birth_date,name)
values(10002, current_date(),'dani');

insert into user_details(id,birth_date,name)
values(10003, current_date(),'nikol');

insert into post(id,description,user_id)
values(2001, 'i want to learn AWS',10001);

insert into post(id,description,user_id)
values(2002, 'i want to learn DeOops',10001);

insert into post(id,description,user_id)
values(2003, 'i want to learn python',10002);

insert into post(id,description,user_id)
values(2004, 'i want to learn AWS',10003);