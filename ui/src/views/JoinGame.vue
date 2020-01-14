<template>
    <div>
        <v-container>
            <v-col>
                <v-row justify="center">
                    <v-card flat color="primary">
                        <v-card-text>
                            <v-text-field
                                v-model="gameCode"
                                color="white"
                                outlined
                                label="Enter game code"
                            ></v-text-field>
                        </v-card-text>
                        <v-card-text>
                            <v-text-field
                                v-model="username"
                                color="white"
                                outlined
                                label="Enter name"
                            ></v-text-field>
                        </v-card-text>

                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="secondary" @click.stop="join">Join Game</v-btn>
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
            gameCode: "",
            username: ""
        };
    },

    methods: {
        join() {
            var joinGameRequest = {
                username: this.username
            };
            axios
                .post(
                    SERVER_URL + "/game/" + this.gameCode + "/join",
                    joinGameRequest
                )
                .then(response => {
                    this.$store.commit("gameJoined", response);
                    this.$router.replace("/join-lobby");
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