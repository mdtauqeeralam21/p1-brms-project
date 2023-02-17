use p0_brms;
SELECT * FROM bus;
SELECT * FROM seat_status;
SELECT * FROM seat_status WHERE Bus_Reg_No="AB-9996";
DELETE FROM seat_status where Bus_Reg_No="";
DELETE FROM bus where Bus_Reg_No="CD-9898" ;
