<template>
    <v-simple-table width="100pc" height="300px">
        <template v-slot:default>
            <thead>
                <tr>
                    <th class="text-left">Player</th>
                    <th class="text-left">Score</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="player in players" :key="player.id">
                    <td>{{ player.username }}</td>
                    <td>0</td>
                </tr>
            </tbody>
        </template>
    </v-simple-table>
</template>

<script>
import { mapState } from "vuex";

export default {
    data() {
        return {};
    },

    computed: {
        ...mapState({
            players: state => state.players
        })
    }
};
</script>