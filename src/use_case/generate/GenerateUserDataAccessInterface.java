package use_case.generate;

import data_access.PlaylistHistoryAccess;

public interface GenerateUserDataAccessInterface {
    void save(PlaylistHistoryAccess playlistsHistory);
}
