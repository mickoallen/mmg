<template>
    <div>
        <v-container>
            <v-col>
                <v-row justify="center">
                    <v-card flat color="primary">
                        <v-card-text>
                            <v-text-field v-model="username" color="white" outlined label="name"></v-text-field>
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="secondary" @click.stop="start">Start Game</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="secondary" to="/">Back</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                    </v-card>
                </v-row>
            </v-col>
        </v-container>
    </div>
</template>
<script>
import axios from "axios";
import { SERVER_URL } from "../config.js";

export default {
    data() {
        return {
            username: ""
        };
    },

    methods: {
        start() {
            var createGameRequest = {
                username: this.username,
            };
            axios
                .put(SERVER_URL + "/game", createGameRequest)
                .then(response => {
                    this.$store.commit("gameCreated", response);
                    this.$router.replace("/lobby");
                })
                .catch(error => {
                    console.log(error);
                });
        }
    }
};
</script>

<style>
</style>