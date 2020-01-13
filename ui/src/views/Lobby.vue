<template>
    <div>
        <v-container>
            <v-subheader color="primary">Game Code: {{game.code}}</v-subheader>
            <v-col>
                <v-row>
                    <v-select
                        :items="playlists"
                        eager
                        single-line
                        item-value="id"
                        item-text="name"
                        label="Genre"
                    />
                </v-row>
                <v-row>
                    <v-switch color="secondary" v-model="songName" class="mx-2" label="Song name"></v-switch>
                </v-row>
                <v-row>
                    <v-switch color="secondary" v-model="artistName" class="mx-2" label="Artist name"></v-switch>
                </v-row>
                <v-row>
                    <v-switch color="secondary" v-model="yearReleased" class="mx-2" label="Year released"></v-switch>
                </v-row>
                <v-row>
                    <v-card color="primary" flat>
                        <v-card-title>Players</v-card-title>
                        <v-list color="primary">
                            <v-list-item v-for="player in players" :key="player.id">
                                <v-list-item-title>{{player.username}}</v-list-item-title>
                            </v-list-item>
                        </v-list>
                    </v-card>
                </v-row>
                <v-row justify="center">
                    <v-card flat color="primary">
                        <v-card-actions>
                            <v-btn color="secondary" to="/create">Start Game</v-btn>
                            <v-btn color="secondary" to="/">Cancel</v-btn>
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
import { mapState } from "vuex";

export default {
    data() {
        return {
            songName: true,
            artistName: true,
            yearReleased: false,
            playlists: [],
            selectedPlaylist: null
        };
    },
    computed: {
        ...mapState({
            user: state => state.user,
            game: state => state.game,
            players: state => state.players
        })
    },
    mounted() {
        axios
            .get(SERVER_URL + "/playlists")
            .then(response => {
                this.playlists = response.data;
            })
            .catch(error => {
                console.log(error);
            });
    }
};
</script>

<style>
</style>