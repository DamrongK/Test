<template>
  <v-container>
  <v-card color="teal lighten-5">

  <v-btn rounded style="margin: 10px ; background-color: #73264d; position: absolute; right: 15px;" @click="Delete" dark>DELETE
        <v-icon dark right>mdi-account-search</v-icon>
      </v-btn>

  <h1 class="text mt-5 pt-5"
      style="text-align: center;
      font: 40px BankGothic Md BT, sans-serif;
      width: 100%;"><strong>FIND STUDENT INFORMATION</strong></h1>
     <v-col cols="10"></v-col> 
    <v-row justify="center">
        <v-col cols="4">
            <v-row justify="center">
            <v-col cols="10">
              <v-text-field
                outlined
                label="STUDENT CODE"
                v-model="search.stuCode"
                :rules="[(v) => !!v || 'กรุณาใส่รหัสนักศึกษา']"
                required
              ></v-text-field>
            </v-col>
            <v-col cols="2">
              <div class="my-2">
                
                <v-dialog v-model="dialog" persistent max-width="290" >
                  <template v-slot:activator="{ on }">
                    <v-btn v-on="on" @click="getStudents" depressed large color="primary">Search</v-btn>
                  </template>
                <v-card>
                  <v-card-title class="headline">notification</v-card-title>
                    <v-card-text v-if="er" >This Student isn't Register</v-card-text>
                    <v-card-text v-if="!er" >Please Insert Student Code !!</v-card-text>
                      <v-card-actions><v-spacer></v-spacer>
                        <v-btn color="green darken-1" text @click="dialog = false">OK</v-btn>
                      </v-card-actions>
                  </v-card>
                </v-dialog>
              </div>
            </v-col>
          </v-row>
        </v-col>
      </v-row>

    <v-row justify="center">
      <v-col  cols="8">
        <v-data-table :headers="headers" 
                      :items="items" 
                      :items-per-page="10" 
                      class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>
    </v-card>
  </v-container>
</template>

<script>
import http from "../Api";

export default {
  name: "search",
  data() {
    return {
      search: {
        stuCode:""
      },
      headers: [
        { text: "STUDENT CODE", value: "stuCode" },
        { text: "NAME", value: "name" },
        { text: "SUBJECT", value: "subject" },
        { text: "PHONE NUMBER", value: "tel" }
      ],
      er:null,
      dialog:false,
      items:[]
    };
  },

  methods: {
    /* eslint-disable no-console */
  Delete(){
      this.$router.push("/Delete")
    },
   

    getStudents() {

      http
        .get("/student")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });

        if(this.search.stuCode != ""){
            http
            .get("/student/" + this.search.stuCode)
            .then(response => {
            if(response.data != ""){
                this.items = response.data;
                console.log(this.items);
                this.dialog = false;
            }else{
                this.er = true;
                this.clear();
            }
            })
            .catch(e => {
            console.log(e);
            });
        }else{
        this.er = false;
        }
    },

    clear() {
      this.items = [];
      this.search.stuCode  = null;

    },
    /* eslint-disable no-console */
  },
  mounted() {
    this.getStudents();
  }

};
</script>