<template>
  <v-container>
    <v-card color="teal lighten-5">

      <v-btn rounded style="margin: 10px ; background-color: #73264d; position: absolute; right: 15px;" @click="Search" dark>SEARCH
        <v-icon dark right>mdi-account-search</v-icon>
      </v-btn>

     <h1 class="text mt-5 pt-5"
      style="text-align: center;
      font: 40px BankGothic Md BT, sans-serif;
      width: 100%;"><strong>ADD STUDENT INFORMATION</strong></h1>
    <v-row justify="center">
      <v-col id = "2" cols="3" sm="4">
          <v-text-field
            label="STUDENT CODE"
            v-model="student.stuCode"
            :rules="[(v) => !!v || '*กรุณาใส่รหัสนักศึกษา']"
            required
            outlined
          ></v-text-field>
      </v-col>
    </v-row>

    <v-row justify="center">
     <v-col id = "3" cols="5" sm="4">
        <v-text-field
            label="NAME"
            v-model="student.name"
            :rules="[(v) => !!v || '*กรุณาใส่ชื่อ-สกุล']"
            required
            outlined
          ></v-text-field>
      </v-col>
    </v-row>
    
    <v-row justify="center">
      <v-col id = "4" cols="3" sm="4">
        <v-text-field
            label="SUBJECT"
            v-model="student.subject"
            :rules="[(v) => !!v || '*กรุณาใส่สาขาวิชา']"
            required
            outlined
          ></v-text-field>
      </v-col>
    </v-row>

      <v-row justify="center">
      <v-col id = "6" cols="12" sm="10" md="4">
          <v-text-field
            label="PHONE NUMBER"
            v-model="student.tel"
            :rules="[(v) => !!v || '*กรุณาใส่เบอร์โทรศัพท์']"
            required
            outlined
          ></v-text-field>
      </v-col>
    </v-row>
    

    <v-row justify="center">
      <v-dialog v-model="dialog" persistent max-width="290" >
        <template v-slot:activator="{ on }">
          <v-btn v-on="on" rounded style="margin: 10px ; background-color: #00C853" @click="saveStudent" dark>ADD
            <v-icon dark right>mdi-checkbox-marked-circle</v-icon>
          </v-btn>
        </template>
          <v-card>
            <v-card-title class="headline">notification</v-card-title>
            <v-card-text v-if="suc" >บันทึกข้อมูลสำเร็จ</v-card-text>
            
            <v-card-actions><v-spacer></v-spacer>
              <v-btn color="green darken-1" text @click="dialog = false">OK</v-btn>
            </v-card-actions>
          </v-card>  
      </v-dialog>
      
    </v-row>
    </v-card>
  </v-container>
</template>

<script>
import http from "../Api";

export default {
  name: "student",
  data() {
    return {
      student: {
        name: ""
      },
      lock:false,
      dialog:false,
      suc:null
    };
  },


 methods: {
    Search(){
      this.$router.push("/Search")
    },
    
    /* eslint-disable no-console */
    

    // function save
    saveStudent() {
      if (
        !this.student.stuCode ||
        !this.student.name ||
        !this.student.subject ||
        !this.student.tel 
      ) {
        this.suc = false;
        this.clear();
      } else {
        http
          .post(
          "/student/"+
            this.student.stuCode +
            "/" +
            this.student.name +
            "/" +
            this.student.subject +
            "/" +
            this.student.tel ,
          this.student
       )
          .then(response => {
            console.log(response);
            this.suc = true;
            this.clear();
          })
          .catch(e => {
            console.log(e);
          });
    }
    },
    
    clear() {
      //this.$refs.form.reset();
      this.student.stuCode = null;
      this.student.name = null;
      this.student.subject = null;
      this.student.tel = null;
      
    }
   
   /* eslint-enable no-console */
  },
  
};
</script>